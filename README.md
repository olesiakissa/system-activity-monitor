# System Activity Monitor

[![forthebadge](https://forthebadge.com/images/badges/made-with-java.svg)](https://forthebadge.com) 
[![forthebadge](https://forthebadge.com/images/badges/built-with-love.svg)](https://forthebadge.com)

[![Build Status](https://travis-ci.org/MasterOfTheU/system-activity-monitor.svg?branch=master)](https://travis-ci.org/MasterOfTheU/system-activity-monitor)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/365bc637d4ae4e008414b3d3c888a424)](https://www.codacy.com/app/MasterOfTheU/system-activity-monitor?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=MasterOfTheU/system-activity-monitor&amp;utm_campaign=Badge_Grade)
![Contributions welcome](https://img.shields.io/badge/contributions-welcome-orange.svg)
[![License](https://img.shields.io/badge/license-MIT-blue.svg)](https://opensource.org/licenses/MIT)

<hr>



## Getting Started

To run this project on your local machine for dev and testing purposes firstly build the project and start the rmiregistry. Open the terminal and run :
```
cd out\production\classes
rmiregistry
```
Then start the server ```Server.java``` and the client ```Client.java``` that are located in default package.
The list of commands will be printed on ```Server``` terminal tab because you monitor the local OS.

List of commands - [commands.txt](src/main/resources/commands.txt) 

## Patterns list
<p>
  <ol>
    <li>Iterator</li>
    <li>Factory Method</li>
    <li>Command</li>
    <li>Strategy</li>
  </ol>
</p>

### Strategy Creator hierarchy 
![packagecreators](https://user-images.githubusercontent.com/15348166/39965747-bafd9182-56a7-11e8-8e59-0ea5a39b0a03.png)

### Implemented commands
![packagecommands](https://user-images.githubusercontent.com/15348166/39965588-b243ac32-56a4-11e8-948b-2721bfe36237.png)

### Command Receiver hierarchy 
![packagereceivers](https://user-images.githubusercontent.com/15348166/39965717-037ee236-56a7-11e8-8741-b570bac6abbe.png)
