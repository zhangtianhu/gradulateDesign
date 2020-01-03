<template>
  <div class="setting">
    <setting-header></setting-header>
    <setting-body></setting-body>
  </div>
</template>

<script>
import SettingBody from './components/Body'
import SettingHeader from './components/Header'
export default {
  name: "Setting",
  components: {
    SettingBody,
    SettingHeader
  }
}
</script>

<style scoped lang="stylus">

</style>
