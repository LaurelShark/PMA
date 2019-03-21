import axios from 'axios'
const API = process.env.VUE_APP_API_URL

export default {
  async loadSupplies({ commit }) {
    try {
      const resp = await axios.get(`supplies`)
      commit('processSuplies', resp)
    } catch(e) {
      console.log('SUPLIES ERROR', e)
    }
   
  }
}