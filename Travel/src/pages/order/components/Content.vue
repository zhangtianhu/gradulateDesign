<template>
  <div class="content">
    <p>最近订单</p>
    <div class="content-body">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <i class="el-icon-tickets" style="color: #25a4bb"></i>
          <span class="title" style="color: #727272; font-family: Helvetica">Travel</span>
          <el-button type="text">待使用</el-button>
        </div>
        <div class="content-list">
          <div>
            <span style="font-size: .32rem">订单号: 123123123123</span>
          </div>
          <p>
            下单时间: 2018-08-31 11：03
          </p>
          <p>
            总价格: ￥4000
          </p>
        </div>
        <div class="bottom">
          <el-button round>继续购买</el-button>
        </div>
      </el-card>
    </div>
  </div>
</template>

<script>
export default {
  name: "OrderContent"
}
</script>

<style scoped lang="stylus">
  .content
    width 100%
    height 5rem
    p
      margin-top .3rem
      margin-left .3rem
      font-size .32rem
    .content-body
      position flex
      .box-card
        margin-top .4rem
        margin-left .3rem
        margin-right .3rem
        border 1
        .content-list
          p
            font-size .25rem
            color #404040
        .bottom
          .el-button
            padding .1rem .3rem
            margin-top .3rem
            margin-bottom .3rem
        .title
          font-size .2rem
        .el-button
          float right
          padding 0
          font-size .2rem
          color #727272
</style>
