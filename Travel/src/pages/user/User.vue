<template>
    <div class="user">
      <user-header/>
      <user-information
        :list="userOrderInfos"
        :name="name"
        :mobile="mobile"
        :photo="photo"
        v-on:userOrderInfosParent="userOrderInfosShow"
      />
    </div>
</template>
<script>
import UserHeader from './components/Header'
import UserInformation from './components/Information'
import axios from "axios"
import OrderRequest from '@/request/order/OrderRequest'
import UserRequest from '@/request/user/UserRequest'
export default {
  name: "User",
  components: {
    UserHeader,
    UserInformation
  },
  data: function() {
    return{
      userOrderInfos: [],
      name: '',
      mobile: '',
      photo: ''
    }
  },
  methods: {
    getUserOrderInfos: function () {
      // 获取用户订单信息列表
      axios.get(OrderRequest.userOrderInfoListUrl,{
        headers: {
          'token': this.$store.state.token
        }
      }).then(res => {
        res = res.data
        if(res.code !== 200){
          this.$notify.error({
            title: '系统',
            message: res.message
          })
          return
        }
        this.userOrderInfos = res.data
      })
    },
    userOrderInfosShow: function() {
      this.getUserOrderInfos()
      this.userInfo()
    },
    userInfo () {
      axios.get(UserRequest.userInfoUrl, {
        headers: {
          'token': this.$store.state.token
        }
      }).then(res => {
        res = res.data
        if(res.code !== 200){
          return
        }
        const data = res.data
        this.name = data.name
        this.mobile = data.mobile
        this.photo = data.photo
      })
    }
  },
  mounted: function () {

  }
}
</script>

<style scoped lang="stylus">
  @import "~styles/varibles.styl"
</style>
