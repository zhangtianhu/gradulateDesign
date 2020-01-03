<template>
  <div class="hotCrunchies">
    <div class="distance"></div>
    <div class="title">
      <img class="hot-img" src="http://img1.qunarzz.com/piao/fusion/1711/16/bfbb9874e8f11402.png"/>
      <span>本周热门榜单</span>
    </div>
    <ul class="items">
      <li class="item" v-for="(item, index) of list" :key="item.crunchiesId">
        <div class="images" v-bind:style="{backgroundImage:'url(' + item.imgUrl + ')'}">
          <div class="top-img" v-show="index <= 2"/>
        </div>
        <div class="content">
          {{item.title}}<br>
          <span class="price">￥{{item.price}}</span>起
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: "HomeHotCrunchies",
  props: {
    list: Array
  }
}
</script>

<style scoped lang="stylus">
  .hotCrunchies
    .distance
      height .2rem
      background-color #eee
    .title
      margin-top .1rem
      line-height .8rem
      text-indent .2rem
      .hot-img
        width .32rem
        height .32rem
        margin-top -.1rem
    .items
      overflow-x auto //x轴有超出部分显示滚动条
      white-space nowrap //不允许换行
      .item
        &:nth-child(1) // 首个li元素设置属性
          margin-left .1rem
          .images .top-img
            background-image url("http://img1.qunarzz.com/piao/fusion/1710/ab/159673b63e6ca702.png")
        &:nth-child(2)
          .images .top-img
            background-image url("http://img1.qunarzz.com/piao/fusion/1710/2d/36d0c4adaebbbc02.png")
        &:nth-child(3)
          .images .top-img
            background-image url("http://img1.qunarzz.com/piao/fusion/1710/67/edc47ffef9e96b02.png")
        display inline-block //行内块级元素
        margin-right .1rem
        .images
          width 2rem
          height 2rem
          background #eee
          background-repeat no-repeat
          background-size cover
          .top-img
            width .84rem
            height .4rem
            background #eee
            background-repeat no-repeat
            background-size cover
        .content
          font-weight 900
          margin-top .12rem
          width 2rem
          height .5rem
          line-height .3rem
          font-size .24rem
          text-align center
          .price
            color #ff8300
            font-weight 900
</style>
