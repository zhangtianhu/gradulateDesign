export default {
  // 改变数据
  changeCity: function (state, city) {
    state.city = city
    try {
      localStorage.city = city
    }catch (e) {

    }
  },
  changeMobileLogin: function (state, mobileLogin) {
    state.mobileLogin = mobileLogin
  },
  changeSMS: function (state, sms) {
    state.sms = sms
  }
}
