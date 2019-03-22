import axios from 'axios'
const API = process.env.VUE_APP_API_URL

export default {
  async loadSupplies({ commit }) {
    try {
      const resp = await axios.get(`${API}/supplies`)
      commit('processSupplies', resp.data)
    } catch(e) {
      console.log('SUPLIES ERROR', e)
    }
   
  }
}