import axios from 'axios'
const API = process.env.VUE_APP_API_URL

export default {
  async loadGoods({ commit }) {
    try {
      const resp = await axios.get(`${API}/goods`)
      commit('processGoods', resp.data)
    } catch(e) {
      console.log('GOODS ERROR', e)
    }
   
  }
}