import { Routes } from '@angular/router';
import { NotificationComponent } from './pages/notification/notification.component';
import { LogComponent } from './pages/log/log.component';
import { AboutComponent } from './pages/about/about.component';

export const routes: Routes = [
    { path: 'notification', component: NotificationComponent },
    { path: 'log', component: LogComponent },
    { path: 'about', component: AboutComponent },
];
