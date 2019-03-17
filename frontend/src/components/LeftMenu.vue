<template>
  <el-menu
    class="left-menu"
      >
      <el-menu-item v-for="route in routes"
                    :key="route.name">
        <router-link :to="{ name: route.name }" class="menu-link">
          <i :class="route.meta.icon"></i>
          {{ route.meta.label }}
        </router-link>
      </el-menu-item>
    </el-menu>
</template>

<script>
export default {
  data() {
    return {
      
    }
  },

  computed: {
    routes() {
      return this.$router.options.routes.filter(({ meta }) => meta && meta.menu)
    }
  }
}
</script>

<style scoped>
  .menu-link {
    display: block;
  }
</style>
