<template>
  <el-row>
    <el-col :span="20">
      <cats-list />
    </el-col>
    <el-col :span="4">
      <el-button
        type="primary"
        icon="el-icon-plus"
        @click="openForm"
      >
        Create
      </el-button>
    </el-col>

    <form-wrapper
      ref="form"
    >
      <cat-form
        @update="onUpdate"
      />
    </form-wrapper>
  </el-row>
  
</template>

<script>
import CatsList from './List'
import CatForm from './Form'
import { mapGetters, mapActions } from 'vuex'

export default {
  created() {
    this.loadCategories()
  },
  components: {
    CatsList,
    CatForm
  },
  
  methods: {
    ...mapActions('Categories', [
      'loadCategories'
    ]),

    openForm() {
      this.$refs.form.openForm()
    },

    closeForm() {
      this.$refs.form.closeForm()
    },
    
    onUpdate() {
      this.$refs.form.closeForm()
      this.loadCategories()
    }
  }
}
</script>