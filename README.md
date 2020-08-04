# Virus Simulation
Project for postgraduate recommendation of MNS
# Inspired By
[KikiLetGo/VirusBroadcast](https://github.com/KikiLetGo/VirusBroadcast), thanks for your contrib.
# Program Design
## Flow Chart
![flowChart](./img/flowChart.png)
## State Machine of Person
![stateMachine](./img/stateMachine.png)
# My work
* Implement an interaction interface
    * Dynamically adjust the Number of bed/Broad rate/
    Respond time/Shadow time/Mortality/Crowd mobility
    * Able to restart/pause/unpause the world
* Add cured person model
    * Cured time satisfies Gaussian distribution
    * Cured people have more immunity against virus
* Modify state machine
    * Assign different fatality value for freeze/confirmed person
# Demo
* KikiLetGo version
![KiKiLetGo](./img/kikiletgo_ver.jpg)
* My version
![Mine1](./img/my_ver.jpg)
![Mine2](./img/my_ver2.jpg)
# TODO
* Introduce mathematical model, such as SEIR model
* Add curves to panel
* Save/Load state
