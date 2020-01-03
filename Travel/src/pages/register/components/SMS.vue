<template>
  <div class="sms" v-show="this.$store.state.sms">
    <el-input placeholder="短信验证码" v-model="code">
      <i slot="suffix">
        <el-button
          class="el-button--mini"
          v-bind:class="{ btnColor: isBtnColor }"
          @click="sendVerificationCode"
          v-bind:disabled="disabled"
          :value="checkValue"
        >
          {{checkValue}}
        </el-button>
      </i>
    </el-input>
    <el-button type="primary" @click="check" >立即验证</el-button>
  </div>
</template>

<script>
import axios from 'axios'
import UserRequest from '@/request/user/UserRequest'
import MessageRequest from '@/request/message/MessageRequest'
export default {
  name: "RegisterSMS",
  data: function() {
    return {
      i: 60,
      disabled: false,
      checkValue: '发送验证码',
      isBtnColor: false,
      code: '',
      timer: null
    }
  },
  methods: {
    check: function (e) {
      let mobile = localStorage.mobile
      let password = localStorage.password
      axios.post(UserRequest.registerUrl, {
          'mobile': mobile,
          'password': password,
          'code': this.code
      }).then(res => {
        res = res.data
        if(res.code !== 200) {
          this.$notify.error({
            title: '错误',
            message: res.message
          });
          return
        }
        // 验证通过并注册成功则跳转到主界面
        this.$router.push("/")
      })
    },
    sendVerificationCode: function (e) {
      // 发送验证码
      axios.get(MessageRequest.sendSMSUrl
        + "?mobile=" + localStorage.mobile)
        .then(res => {
          res = res.data
          if(res.code !== 200) {
            this.$notify.error({
              title: '错误',
              message: res.message
            });
          }
        })
      this.changVerificationCodeButton()
    },
    changVerificationCodeButton: function () {
      this.timer = setInterval(() => {
        if(this.i < 0) {
          this.disabled = false
          this.isBtnColor = false
          this.checkValue = "重新获取"
          this.i = 60
          if(this.timer) {
            clearInterval(this.timer)
          }
          return
        }
        this.disabled = true
        this.isBtnColor = true
        this.checkValue = "重发("+this.i+")"
        this.i--;
      },1000)
      this.$notify({
        message: '验证码已经发送至' + localStorage.mobile,
        type: 'success'
      })
    }
  }
}
</script>

<style scoped lang="stylus">
  .sms
    display: flex
    justify-items center
    flex-direction column
    align-items center
    width 100%
    .tip
      width 5.65rem
      padding-top .15rem
      line-height .35rem
      color #9e9e9e
      font-size small
    .el-input
      width 5.7rem
      &:nth-child(1)
        margin-top .8rem
    .el-button
      &:nth-child(2)
        height .9rem
        margin-top .4rem
        width 5.7rem
        margin-bottom 100%
    .el-input >>> input
      height .9rem
      outline none
    .color
      color red
    .el-button--mini
      font-size .3rem
      margin-top .05rem
      height 90%
      padding-left 0
      padding-right .1rem
      border 0
      color #5a9df8
      background-color transparent
    .btnColor
      color #c3c6cd
</style>
