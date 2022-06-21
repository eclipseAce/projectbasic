<template>
  <div class="app-container">
    <div class="dashboard-text">name: {{ name }}</div>
    <div class="dashboard-text">roles: {{ roles.join(',') }}</div>
  </div>
</template>

<script>
import { mapGetters } from 'vuex'

export default {
  name: 'Profile',
  computed: {
    ...mapGetters([
      'name',
      'roles'
    ])
  }
}
</script>
