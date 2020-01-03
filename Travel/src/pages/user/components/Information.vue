<template>
  <div class="information" ref="wrapper">
    <div>
      <div class="list user">
        <div style="display: inline-flex">
          <img :src="photo" class="user-img"/>
          <div class="user-desc">
            <p class="name">{{name}}</p>
            <p>{{mobile}}</p>
          </div>
        </div>
        <div class="iconfont right-icon">
          &#xe634;
        </div>
      </div>
      <div class="list">
        我的旅行
      </div>
      <div class="list border-bottom nav"
           v-for="(item) of list"
           :key="item.id"
           @click="orderDetail(item.orderTypeId,item.name)"
      >
        <div style="display: inline-flex">
          <img :src="item.icon"/>
          <div class="font">
            {{item.name}}
          </div>
        </div>
        <div style="display: inline-flex">
          <el-badge :value="item.number" class="item" v-show="!item.number == 0"/>
          <div class="right iconfont">
            &#xe634;
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  import Bscroll from "better-scroll"
  export default {
    name: "UserInformation",
    props: {
      list: Array,
      name: '',
      mobile: '',
      photo: ''
    },
    data: function () {
      return {
        downRefresh: false
      }
    },
    mounted: function () {
      // 这里设置延迟加载TMD这插件有时候还没等DOM渲染完毕就搞事情导致不能滚动
      setTimeout(() => {
        this._initScroll()
      }, 200)
    },
    activated: function() {
      this.$emit('userOrderInfosParent')
    },
    methods: {
      _initScroll: function () {
        // better-scroll的初始化
        this.scroll = new Bscroll(this.$refs.wrapper, {
          probeType: this.probeType
        })
      },
      handleScroll: function (e) {
        // TODO 实现下拉刷新
        console.log(e)
      },
      // 该类型订单列表
      orderDetail: function (orderTypeId, name) {
        this.$store.state.orderTypeId = orderTypeId
        this.$store.state.name = name
        console.log(this.$store.state.name);
        // 跳转到订单列表
        this.$router.push("/order")
      }
    }
  }
</script>

<style scoped lang="stylus">
  @import "~styles/varibles.styl"
  .information
    overflow hidden
    position absolute
    top 0.83rem
    left 0
    right 0
    bottom 0
    div
      .user
        background $bgColor
        height: 2rem
        width: 100%
        display flex
        justify-content space-between
        .iconfont
          margin-top .65rem
          color white
        .right-icon
          width: .8rem
          font-size .2rem
          font-weight bolder
      .nav
        line-height .8rem
        background white
        display flex
        justify-content space-between
        color #6a6a6a
        img
          margin-top .15rem
          float left
          width .5rem
          height .5rem
        .font
          font-size .28rem
          margin-left .3rem
        .right
          padding-right .23rem
          font-size .2rem
          font-weight bolder
          color #cacaca
    .list
      line-height .54rem
      background #f5f5f5
      padding-left .3rem
      font-size .26rem
      color #216d81
      .user-img
        padding-top .2rem
        height 1.3rem
        width 1.3rem
        margin-left .1rem
      .user-desc
        color #f2f2f2
        padding-top .3rem
        margin-left .4rem
        height 1.7rem
        width 1.7rem
        .name
          font-size .35rem
</style>
