import Vue from "vue";
import Router from "vue-router";
import Home from "./views/Home.vue";

import GoodsList from '@/modules/goods/Index'
import CatsList from '@/modules/categories/Index'
import ReceiptsList from '@/modules/receipts/Index'
import UsersList from '@/modules/users/Index'

Vue.use(Router);

export default new Router({
  mode: "history",
  base: process.env.BASE_URL,
  routes: [
    {
      path: "/",
      name: "home",
      component: Home
    },
    {
      path: "/about",
      name: "about",
      // route level code-splitting
      // this generates a separate chunk (about.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () =>
        import(/* webpackChunkName: "about" */ "./views/About.vue")
    },
    {
      path: '/goods',
      name: 'goods',
      component: GoodsList,
      meta: {
        menu: true,
        label: 'Goods',
        icon: 'el-icon-goods'
      }
    },
    {
      path: '/categories',
      name: 'categories',
      component: CatsList,
      meta: {
        menu: true,
        label: 'Categories',
        icon: 'el-icon-more'
      }
    },
    {
      path: '/receipts',
      name: 'receipts',
      component: ReceiptsList,
      meta: {
        menu: true,
        label: 'Receipts',
        icon: 'el-icon-plus'
      }
    },
    {
      path: '/users',
      name: 'users',
      component: UsersList,
      meta: {
        menu: true,
        label: 'Users',
        icon: 'el-icon-star-on'
      }
    }
  ]
});
