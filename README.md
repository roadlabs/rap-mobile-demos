RAP mobile Demos
================

This repository contains a single Eclipse project that is used within the [RAP mobile Screencasts](http://rapmobile.eclipsesource.com/demos/). The steps to get this running are described [here](http://rapmobile.eclipsesource.com/developers/getting-started/). After running this project the following Entrypoints are available:

iOS:

* http://SERVER:9090/ios-input
* http://SERVER:9090/ios-buttons
* http://SERVER:9090/ios-simple-tree 
* http://SERVER:9090/ios-virtual-tree (Read the note below!)

Android:

* http://SERVER:9090/android-input
* http://SERVER:9090/android-buttons
* http://SERVER:9090/android-simple-tree
* http://SERVER:9090/android-virtual-tree (Read the note below!)

Please replace SERVER with your ip address.

IMPORTANT: Virtual Tree
-----------------------
To run the virtual tree example you need to download the [Enron Email Dataset](http://www.cs.cmu.edu/~enron/) 
to your local machine. After this is done you need to change the constant DEFAULT_DATASET_DIR within the 
com.eclipsesource.rap.mobile.demos.enron.EnronExample class to point to your maildir destination.
After this please point your web browser to http://SERVER:9090/ios?startup=virtual-tree. It may take som eminutes before
the ui will be displayed because the example needs to create some .index files. Don't worry, this happens only once.  

Build
-----
There are some build projects located in the build directory. The build compiles the demo project into a war file that can be deployed
on a servlet container. The build uses [Maven Tycho](http://eclipse.org/tycho/) and can be launched when Maven 3 is installed. Simply step to the build/com.eclipsesource.rap.mobile.demos.build folder and run "mvn clean verify". After the build has succeeded you will find the .war file within the build/com.eclipsesource.rap.mobile.demos.product/target folder. 

Alternatively you can use the [Eclipse m2e Tooling](http://eclipse.org/m2e/) and run the launch configuration located in build/com.eclipsesource.rap.mobile.demos.build.

License
-------
The code is published under the terms of the [Eclipse Public License, version 1.0](http://www.eclipse.org/legal/epl-v10.html).
