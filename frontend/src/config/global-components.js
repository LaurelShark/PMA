import FormWrapper from '@/components/FormWrapper'
import Vue from 'vue'

export default function() {
  const components = {
    FormWrapper
  }
  
  Object.keys(components).forEach(componentName => {
    Vue.component(componentName, components[componentName]);
  })
}
