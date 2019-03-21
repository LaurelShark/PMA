import axios from 'axios'
const API = process.env.VUE_APP_API_URL

export default {
  async loadOrders({ commit }) {
    try {
      const resp = await axios.get(`orders`)
      commit('processOrders', resp.data)
    } catch(e) {
      console.log('ORDERS ERROR', e)
    }
   
  }
}