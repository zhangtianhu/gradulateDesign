<template>
  <ul class="list">
    <li
      class="item"
      v-for="item of letters"
      :key="item"
      :ref="item"
      :data-index="item"
      @click="onShortcutStart"
      @touchstart="handleTouchStart"
      @touchmove="handleTouchMove"
      @touchend="handleTouchEnd"
    >
      {{item}}
    </li>
  </ul>
</template>

<script>
export default {
  name: "CityAlphabet",
  props: {
    cities: Object
  },
  data() {
    return {
      touchStatus: false,
      startY: 0,
      timer: null
    }
  },
  updated: function() {
    // A元素距离该外层DIV的大小
    this.startY = this.$refs['A'][0].offsetTop
  },
  computed: {
    letters: function () {
      const letters = []
      for (let i in this.cities){
        letters.push(i)
      }
      return letters
    }
  },
  methods: {
    onShortcutStart: function (e) {
      let index = e.currentTarget.getAttribute('data-index')
      this.$emit('touchstart', index)
    },
    handleTouchStart: function() {
      this.touchStatus = true
    },
    handleTouchMove: function(e) {
      if (this.touchStatus) {
        // 使用函数节流方式优化handleTouchMove出发的频率
        if(this.timer) {
          clearTimeout(this.timer)
        }
        this.timer = setTimeout(() => {
          // 元素距离页面最顶部的大小 然后减去顶部DIV的高度
          const touchY = e.touches[0].clientY - 79
          // 距离页面最顶部的高度-元素距离该外层DIV的高度 / 每个元素的高度 再取整
          const index = Math.floor((touchY - this.startY) / 20)
          if(index >= 0 && index < this.letters.length) {
            this.$emit('touchstart', this.letters[index])
          }
        }, 16)
      }
    },
    handleTouchEnd: function() {
      this.touchStatus = false
    },
  }
}
</script>

<style scoped lang="stylus">
  @import "~styles/varibles.styl"
  .list
    display flex
    flex-direction column
    justify-content center
    position absolute
    right 0
    top 1.58rem
    bottom 0
    width .4rem
    .item
      line-height .4rem
      text-align center
      color $bgColor
</style>
