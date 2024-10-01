import {createRouter, createWebHistory} from 'vue-router';
import Home from '../pages/Home.vue';
import Streetlights from '../pages/StreetlightPage.vue';
import ManagementRules from '../pages/ManagementRulePage.vue';

const routes = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path: '/',
            name: 'home',
            component: Home
        },
        {
            path: '/lampadaire',
            name: 'lampadaire',
            component: Streetlights
        },
        {
            path: '/managementrules',
            name: 'managementRules',
            component: ManagementRules
        }
    ]
});

export default routes;