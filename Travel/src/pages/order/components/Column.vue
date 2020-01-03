<template>
  <div class="column">
    <div class="nav">
      <img src="http://travelproject.oss-cn-hangzhou.aliyuncs.com/travelfolder153564697730010302.file?Expires=1851006977&OSSAccessKeyId=LTAIY32ReEvm2zAS&Signature=lJlwOwp%2Filcq%2FJAGouuzdhGHCAw%3D"/>
      <div>待付款</div>
    </div>
    <div class="nav">
      <img src="http://travelproject.oss-cn-hangzhou.aliyuncs.com/travelfolder153564700558110398.file?Expires=1851007005&OSSAccessKeyId=LTAIY32ReEvm2zAS&Signature=RmsB1lFJibUUQTcfK4qtOuvlFoQ%3D"/>
      <div>待使用</div>
    </div>
    <div class="nav">
      <img src="http://travelproject.oss-cn-hangzhou.aliyuncs.com/travelfolder153564703172910451.file?Expires=1851007031&OSSAccessKeyId=LTAIY32ReEvm2zAS&Signature=PN9%2BQtNOdShABHPwXGkzU5Nzino%3D"/>
      <el-badge is-dot>待评价</el-badge>
    </div>
    <div class="nav">
      <img src="http://travelproject.oss-cn-hangzhou.aliyuncs.com/travelfolder153564706649310391.file?Expires=1851007066&OSSAccessKeyId=LTAIY32ReEvm2zAS&Signature=vsTtP84DmRHBUvGHA8fKOp5JqSA%3D"/>
      <div>退款/售后</div>
    </div>
    <div class="nav">
      <img src="http://travelproject.oss-cn-hangzhou.aliyuncs.com/travelfolder153564709534810395.file?Expires=1851007095&OSSAccessKeyId=LTAIY32ReEvm2zAS&Signature=MOSJDHRFbPJHoSlAM7nw2zMdkO8%3D"/>
      <div>全部订单</div>
    </div>
  </div>
</template>
<script>
export default {
  name: "OrderColumn"
}
</script>

<style scoped lang="stylus">
  .column
    width 100%
    margin-top .25rem
    display inline-flex
    justify-content space-around
    .nav
      width 1.1rem
      height 1.3rem
      text-align center
      line-height .6rem
      img
        width .6rem
        height .6rem
      div
        width 1.1rem
        height .2rem
        font-size .1rem
        color #6e6e6e
      .el-badge
        display: block
</style>
