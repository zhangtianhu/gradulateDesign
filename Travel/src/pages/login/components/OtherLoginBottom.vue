<template>
  <transition name="el-fade-in-linear">
    <div class="body" v-show="!this.mobileLogin">
      <div class="bottom" v-show="!this.mobileLogin">
          <span class="iconfont" @click="changeMobileLogin">
            其他登录方式<span> > </span>
          </span>
      </div>
    </div>
  </transition>
</template>

<script>
import { mapState} from 'vuex'
export default {
  name: "LoginOtherLoginBottom",
  computed: {
    ...mapState(['mobileLogin'])
  },
  methods: {
    changeMobileLogin: function (e) {
      this.$store.commit('changeMobileLogin', !this.mobileLogin)
    }
  }
}
</script>

<style scoped lang="stylus">
  .bottom
    height .8rem
    text-align center
    position absolute
    bottom 0
    .iconfont
      height 100%
      width 100%
      position fixed
</style>
