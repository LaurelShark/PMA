<template>
  <div id="app">
    <el-container>
      <el-aside width="200px">
        <left-menu />
      </el-aside>
      <div class="content">
        <router-view />
      </div>
    </el-container>
  </div>
</template>

<script>
import LeftMenu from '@/components/LeftMenu'

export default {
  components: {
    LeftMenu
  }
}
</script>

<style>
  @font-face {
    font-family: 'roboto';
    src: url('assets/fonts/roboto/Roboto-Regular.ttf');
  }
  body {
    font-family: 'roboto', sans-serif;
    background-color: #e5e9f2;
  }
  #app {
    max-width: 1400px;
    margin: 0 auto;
  }
  * {
    outline: none
  }
  a {
    text-decoration: none;
  }

  .content {
    width: 100%;
    background-color: #fff;
    padding: 20px;
  }
  
</style>
