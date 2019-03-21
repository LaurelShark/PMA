import Vue from "vue";
import Vuex from "vuex";
import Categories from './categories'
import Goods from './goods'
import Orders from './orders'
import Providers from './providers'
import Receipts from './receipts'
import Supplies from './supplies'
import Users from './users'

Vue.use(Vuex);

export default new Vuex.Store({
  modules: {
    Categories,
    Goods,
    Orders,
    Providers,
    Receipts,
    Supplies,
    Users
  }
});
