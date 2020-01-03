import global from '@/Global'

const registerUrl = global.serverAddress + "/user/user/register"
const judgeTokenUrl = global.serverAddress + "/user/user/judgeToken"
const userInfoUrl = global.serverAddress + "/user/user/userInfo"

export default ({
  registerUrl,
  judgeTokenUrl,
  userInfoUrl
})
