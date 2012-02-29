/*******************************************************************************
 * Copyright (c) 2012 EclipseSource and others. All rights reserved. This
 * program and the accompanying materials are made available under the terms of
 * the Eclipse Public License v1.0 which accompanies this distribution, and is
 * available at http://www.eclipse.org/legal/epl-v10.html Contributors:
 * EclipseSource - initial API and implementation
 ******************************************************************************/
package com.eclipsesource.rap.mobile.demos;

import org.eclipse.rwt.application.ApplicationConfiguration;
import org.eclipse.rwt.application.ApplicationConfiguration.OperationMode;
import org.eclipse.rwt.application.ApplicationConfigurator;
import org.eclipse.rwt.internal.application.ApplicationConfigurationImpl;
import org.eclipse.rwt.lifecycle.IEntryPoint;

import com.eclipsesource.rap.mobile.demos.entrypoints.ButtonControlsDemo;
import com.eclipsesource.rap.mobile.demos.entrypoints.GalleryDemo;
import com.eclipsesource.rap.mobile.demos.entrypoints.InputControlsDemo;
import com.eclipsesource.rap.mobile.demos.entrypoints.SimpleTreeDemo;
import com.eclipsesource.rap.mobile.demos.entrypoints.VirtualTreeDemo;

public class Configurator implements ApplicationConfigurator {

  private static final String DEFAULT_THEME_ID = "org.eclipse.rap.rwt.theme.Default";
  private static final String IOS_THEME_ID = "org.eclipse.rap.rwt.theme.ios";
  private static final String THEME_PATH_IOS = "theme/ios.css";
  private static final String THEME_PATH_ANDROID = "theme/theme-android-holo.css";

  public void configure( ApplicationConfiguration configuration ) {
    setUp( configuration );
    addApplication( configuration, "/input", InputControlsDemo.class );
    addApplication( configuration, "/buttons", ButtonControlsDemo.class );
    addApplication( configuration, "/virtual-tree", VirtualTreeDemo.class );
    addApplication( configuration, "/simple-tree", SimpleTreeDemo.class );
    addApplication( configuration, "/gallery", GalleryDemo.class );
    defineBackwardCompatibleEntryPoints( configuration );
  }

  private void defineBackwardCompatibleEntryPoints( ApplicationConfiguration configuration ) {
    ApplicationConfigurationImpl aci = ( ApplicationConfigurationImpl )configuration;
    aci.addEntryPointByParameter( "input", InputControlsDemo.class );
    aci.addEntryPointByParameter( "buttons", ButtonControlsDemo.class );
    aci.addEntryPointByParameter( "virtual-tree", VirtualTreeDemo.class );
    aci.addEntryPointByParameter( "simple-tree", SimpleTreeDemo.class );
    aci.addEntryPointByParameter( "gallery", GalleryDemo.class );
  }

  public void addApplication( ApplicationConfiguration configuration,
                              String id,
                              Class<? extends IEntryPoint> type )
  {
    configuration.setOperationMode( OperationMode.JEE_COMPATIBILITY );
    configuration.addEntryPoint( id, type );
  }

  private void setUp( ApplicationConfiguration configuration ) {
    configuration.addStyleSheet( DEFAULT_THEME_ID, THEME_PATH_ANDROID );
    configuration.addStyleSheet( IOS_THEME_ID, THEME_PATH_IOS );
    configuration.addBranding( new Branding( "android" ) );
    configuration.addBranding( new Branding( "ios", IOS_THEME_ID ) );
  }
}
