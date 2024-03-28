# Role Manager ☕

A **Spring Boot** web application that controls users permissions, 
allowing or restricting actions like creating, deleting, and updating other users data, 
based on the roles that were assigned to them. </br>

## Live Demo 💻

- ### Requirements

  - [Java 11](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html) or higher.

- ### Steps

  - Download [this JAR file](https://github.com/arzak21st/role-manager/releases/download/v0.0.1-SNAPSHOT/role-manager-0.0.1-SNAPSHOT.jar).
  - Open your command-line and navigate to where your downloaded JAR file is located.
  - Run the JAR file with the following command:
      ```
      java -jar role-manager-0.0.1-SNAPSHOT.jar
      ```
  - Open the browser and navigate to the following URL:
      ```
      http://localhost:4869/role-manager
      ```
      > **Username**: admin </br>
      > **Password**: 4869 </br>

## Installation 🔌

- ### Requirements

  - [Java 11](https://docs.aws.amazon.com/corretto/latest/corretto-11-ug/downloads-list.html) or higher.
  - [Maven](https://maven.apache.org/download.cgi).
  - [Git](https://git-scm.com/downloads).
  - [NetBeans 19](https://netbeans.apache.org/front/main/download/nb19/).
    > You can use any other Java IDE, just make sure it uses the mentioned **Java 11**, and **Maven**. </br>

- ### Steps

  - Press the **Fork** button (top right the page) to make a copy of this project on your own GitHub account.
  - Open **Git Bash** and navigate to where you want your forked project to be cloned.
  - Clone the project with the following command:
      ```
      git clone https://github.com/your-username/your-forked-project-name.git
      ```
      > Replace `your-username` with the actual username of your GitHub account, and `your-forked-project-name` with the actual name of your forked project. </br>
  - Open **NetBeans** (or any other Java IDE) and try to import your cloned project.

## Additional Information 🔥

If a user with the role ADMIN or UPDATER have changed their own role(s), the change won't take effect until the next login. 
Though I think this is a bug that needs to be fixed! </br>
