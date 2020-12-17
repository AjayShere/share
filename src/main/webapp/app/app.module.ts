import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import './vendor';
import { ShareMarketSharedModule } from 'app/shared/shared.module';
import { ShareMarketCoreModule } from 'app/core/core.module';
import { ShareMarketAppRoutingModule } from './app-routing.module';
import { ShareMarketHomeModule } from './home/home.module';
import { ShareMarketEntityModule } from './entities/entity.module';
// jhipster-needle-angular-add-module-import JHipster will add new module here
import { MainComponent } from './layouts/main/main.component';
import { NavbarComponent } from './layouts/navbar/navbar.component';
import { FooterComponent } from './layouts/footer/footer.component';
import { PageRibbonComponent } from './layouts/profiles/page-ribbon.component';
import { ErrorComponent } from './layouts/error/error.component';

@NgModule({
  imports: [
    BrowserModule,
    ShareMarketSharedModule,
    ShareMarketCoreModule,
    ShareMarketHomeModule,
    // jhipster-needle-angular-add-module JHipster will add new module here
    ShareMarketEntityModule,
    ShareMarketAppRoutingModule,
  ],
  declarations: [MainComponent, NavbarComponent, ErrorComponent, PageRibbonComponent, FooterComponent],
  bootstrap: [MainComponent],
})
export class ShareMarketAppModule {}
