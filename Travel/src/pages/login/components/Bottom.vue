<template>
  <transition name="el-fade-in-linear">
    <div class="bottom" v-show="this.mobileLogin">
      <span class="iconfont">
        第三方企业
        <span style="color: #cacaca">|</span>
          更多
        <span>
          >
        </span>
      </span>
    </div>
  </transition>
</template>

<script>
import { mapState} from 'vuex'
export default {
  name: "LoginBottom",
  computed: {
    ...mapState(['mobileLogin'])
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
