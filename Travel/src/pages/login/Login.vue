<template>
  <div id="login">
    <login-header></login-header>
    <login-brand></login-brand>
    <login-body></login-body>
    <login-mobile-login-body/>
    <login-bottom></login-bottom>
    <login-other-login-bottom/>
  </div>
</template>

<script>
import LoginHeader from './components/Header'
import LoginBrand from './components/Brand'
import LoginBody from './components/Body'
import LoginBottom from './components/Bottom'
import LoginMobileLoginBody from './components/MobileLoginBody'
import LoginOtherLoginBottom from './components/OtherLoginBottom'
export default {
  name: "Login",
  components: {
    LoginOtherLoginBottom,
    LoginHeader,
    LoginBrand,
    LoginBody,
    LoginBottom,
    LoginMobileLoginBody
  }
}
</script>

<style scoped lang="stylus">
  #login
    background-color #eaeaea
</style>
