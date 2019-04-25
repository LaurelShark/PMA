import axios from 'axios'
const API = process.env.VUE_APP_API_URL

export default {
  async loadReceipts({ commit }) {
    try {
      const resp = await axios.get(`${API}/receipts`)
      commit('processReceipts', resp.data)
    } catch(e) {
      console.log('RECEIPTS ERROR', e)
    }
   
  },

  async createReceipt({ commit }, payload) {
    try {
      const resp = await axios.post(`${API}/receipts`, payload)
    } catch(e) {
      throw new Error('RECEIPTS ERROR')
    }
  }
}