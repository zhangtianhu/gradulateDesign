let defalutCity = '北京'

// 使用try catch防止用户关闭本地存储或者使用隐身模式造成的程序奔溃
try {
  if (localStorage.city) {
    defalutCity = localStorage.city
  }
}catch (e) {

}

export default {
  // city默认先从localStorage中去获取数据若没有则使用默认值
  city: defalutCity,
  mobileLogin: true,
  sms: false,
  token: '', // 用户TOKEN
  orderTypeId: '' // 订单类型ID
}
