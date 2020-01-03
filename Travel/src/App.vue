<template>
  <div id="app">
    <!--
      使用keep-alive当第一次显示路由的内容就会被放入内存中,
      下次路由会从内存中获取数据
    -->
    <keep-alive>
      <!--
        当前路由地址所对应的内容
      -->
      <router-view/>
    </keep-alive>
  </div>
</template>

<script>
export default {
  name: 'App'
}
</script>

<style>

</style>
