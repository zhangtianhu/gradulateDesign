<template>
  <div class="order">
    <order-header></order-header>
    <order-column></order-column>
    <order-content></order-content>
  </div>
</template>

<script>
import OrderHeader from "./components/Header"
import OrderColumn from "./components/Column"
import OrderContent from './components/Content'
import axios from "axios"
import OrderRequest from "@/request/order/OrderRequest"
import { Loading } from 'element-ui'
export default {
  name: "Order",
  components: {OrderContent, OrderColumn, OrderHeader},
  methods: {
    orderInfoList: function () {
      // 显示loading
      let loading = Loading.service({ fullscreen: true });
      // 根据订单类型Id和用户的Token去查询
      axios.get(OrderRequest.orderInfoListUrl
        + "?orderTypeId="
        + this.$store.state.orderTypeId,{
          headers: {
            'token': this.$store.state.token
          }
      }).then(res => {
        res = res.data
        if(res.code !== 200) {
          this.$nextTick(() => {
            loading.close();
          });
          this.$notify.error({
            title: "系统",
            message: res.message
          })
          return
        }
        this.$nextTick(() => {
          loading.close();
        });
        console.log(res)
      })
    }
  },
  activated: function () {
    this.orderInfoList()
  }
}
</script>

<style scoped lang="stylus">

</style>
