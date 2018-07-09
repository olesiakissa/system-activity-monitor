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

List of currently available commands - [commands.txt](src/main/resources/commands.txt) 

## Commands description
  <pre>  
  <ol>
    <li><p><strong>pr -a</strong>   | prints out the list of currently available commands.</p></li> 
    <li><p><strong>os</strong>      | prints out the information about OS architecture.</p></li> 
    <li><p><strong>cpu</strong>     | prints out cpu recent usage (might print out 0.0% when is first being invoked).</p></li> 
    <li><p><strong>mem</strong>     | prints out information about the usage of physical and virtual memory.</p></li> 
    <li><p><strong>show cl</strong> | prints out the list of clients (list of their IP addresses) within network per month.</p></li> 
    <li><p><strong>save st</strong> | saves the values of memory and cpu usage into database for all clients per month.</p></li> 
    <li><p><strong>q</strong>       | exits the application.</p></li> 
  </ol>  
</pre>