<template>
  <div id="register">
    <register-header></register-header>
    <register-brand></register-brand>
    <register-mobile-register-body  v-on:register="sms"/>
    <register-s-m-s ref="sms"></register-s-m-s>
  </div>
</template>

<script>
import RegisterHeader from './components/Header'
import RegisterBrand from './components/Brand'
import RegisterMobileRegisterBody from './components/MobileRegisterBody'
import RegisterSMS from './components/SMS'
export default {
  name: "Register",
  components: {
    RegisterHeader,
    RegisterBrand,
    RegisterMobileRegisterBody,
    RegisterSMS
  },
  methods: {
    sms: function () {
      this.$refs.sms.sendVerificationCode()
    }
  }
}
</script>

<style scoped lang="stylus">
  #register
    background-color #eaeaea
</style>
