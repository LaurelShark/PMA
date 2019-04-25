import axios from 'axios'
const API = process.env.VUE_APP_API_URL

export default {
  async loadOrders({ commit }) {
    try {
      const resp = await axios.get(`${API}/orders`)
      commit('processOrders', resp.data)
    } catch(e) {
      console.log('ORDERS ERROR', e)
    }
  },

  async createOrder({ commit }, payload) {
    try {
      const resp = await axios.post(`${API}/orders`, payload)
    } catch(e) {
      throw new Error('ORDERS ERROR')
    }
  },

  async updateOrder({ commit }, payload) {
    try {
      const resp = await axios.put(`${API}/orders`, payload)
    } catch(e) {
      throw new Error('ORDERS ERROR')
    }
  }
}