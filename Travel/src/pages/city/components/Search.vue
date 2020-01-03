<template>
  <div>
    <div class="search">
      <input v-model="keyword" class="search-input" type="text" placeholder="输入城市名或拼音"/>
    </div>
    <div
      class="search-content"
      ref="search"
      v-show="keyword"
    >
      <ul>
        <li class="search-item border-bottom"
            v-for="item of list"
            :key="item.id"
            @click="handleCityClick(item.name)"
        >
          {{item.name}}
        </li>
        <li class="search-item border-bottom" v-show="hasNoData">
          没有找到匹配项
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
import Bscroll from "better-scroll"
export default {
  name: "CitySearch",
  props: {
    cities: Object
  },
  data: function () {
    return {
      keyword: '',
      list: [],
      timer: null
    }
  },
  computed: {
    hasNoData: function () {
      return !this.list.length
    }
  },
  // 监听器
  watch: {
    keyword: function () {
      if(this.timer) {
        clearTimeout(this.timer)
      }
      if (!this.keyword) {
        this.list = []
        return
      }
      // 使用数据节流延迟加载100毫秒提升搜索性能
      this.timer = setTimeout(() => {
        const result = []
        for (let i in this.cities) {
          this.cities[i].forEach(value => {
            // 若匹配姓名或者拼音则添加到数组中
            if(value.spell.indexOf(this.keyword) > -1 ||
               value.name.indexOf(this.keyword) > -1) {
              result.push(value)
            }
          })
        }
        this.list = result
      }, 100)
    }
  },
  methods: {
    handleCityClick: function (city) {
      // 通过调用commit方法让Mutations去改变数据的状态
      // 注意：可以跳过dispatch方法直接使用commit方法
      // 详细可以参照store文件夹下的vuex.png图片
      this.$store.commit('changeCity', city)
      // 使用router脚本去调转页面
      this.$router.push('/')
    }
  },
  mounted: function () {
    this.scroll = new Bscroll(this.$refs.search)
  }
}
</script>

<style scoped lang="stylus">
  @import "~styles/varibles.styl"
  .search
    height .72rem
    padding 0 .1rem
    background $bgColor
    .search-input
      box-sizing border-box
      width 100%
      height .62rem
      padding 0 .1rem
      height .62rem
      line-height .62rem
      text-align center
      border-radius .06rem
      color #666
  .search-content
    z-index 1
    overflow hidden
    position absolute
    top 1.58rem
    left 0
    right 0
    bottom 0
    background #eee
    .search-item
      line-height .62rem
      padding-left .2rem
      background #fff
      color #666
</style>
