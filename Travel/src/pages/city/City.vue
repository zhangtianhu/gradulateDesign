<template>
  <div>
    <city-header></city-header>
    <city-search :cities="cities"></city-search>
    <city-list :cities="cities" ref="citylist" :hotCities="hotCities"></city-list>
    <city-alphabet v-on:touchstart="touchstart" :cities="cities"></city-alphabet>
  </div>
</template>

<script>
import axios from "axios"
import CityHeader from "./components/Header"
import CitySearch from "./components/Search"
import CityList from "./components/List"
import CityAlphabet from "./components/Alphabet"
import global from '@/Global'
export default {
  name: "City",
  components: {
    CityHeader,
    CitySearch,
    CityList,
    CityAlphabet
  },
  data: function() {
    return {
      cities : {},
      hotCities: [],
    }
  },
  methods: {
    getCityInfo: function () {
      axios.get(global.cityList)
        .then(res => {
          res = res.data
          if(res.data) {
            const data = res.data
            this.cities = data.cities
            this.hotCities = data.hotCities
          }
        })
    },
    touchstart: function (e) {
      this.$refs.citylist.touchstart(e)
    },
  },
  mounted: function () {
    this.getCityInfo()
  }
}
</script>

<style scoped lang="stylus">

</style>
