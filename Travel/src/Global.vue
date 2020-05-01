<script>
// const serverAddress = "http://localhost:8081/swagger" // 带有网关服务器地址
const serverAddress = "http://localhost:10002" // 测试时直接访问接口地址
const serverAddressSms = "http://localhost:10001"
// const serverAddress = "http://localhost:8888"
// const homeList = serverAddress + "/information/home/list" // 主页数据集
const homeList = 'http://localhost:8888/api/index.json' 
const cityList = "http://localhost:8888/api/city.json" // 城市列表

const qqAppId = "1107708305" // QQ APPID
const qqKey = "0EFiMM8iI4qByOMl" // QQ KEY

export default {
  serverAddress,
  serverAddressSms,
  homeList,
  cityList,
  qqAppId,
  qqKey
}
</script>

