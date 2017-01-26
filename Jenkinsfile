podTemplate(label: 'mypod', cloud: 'prestige-cluster',
  containers: [
    containerTemplate(name: 'jenkins-jnlp', image: 'artyou/jenkins-slave:0.1.2', command: 'cat', ttyEnabled: true, privileged: true),
    containerTemplate(name: 'jnlp', image: 'jenkinsci/jnlp-slave:alpine', args: '${computer.jnlpmac} ${computer.name}', privileged: true),
  ],
  volumes: [hostPathVolume(hostPath: '/var/run/docker.sock', mountPath: '/var/run/docker.sock')]) {
  node('mypod') {
      stage('build and test') {
        checkout scm
        docker.image('mhart/alpine-node:4.4.3').inside {
          env.NODE_ENV = "test"
          sh 'apk add --update make gcc g++ python git'
          sh 'npm install'
          sh 'npm test'
        }
      }

      stage('push-image') {
        docker.withRegistry('http://localhost:5000') {
          def img = docker.build("artyou/company")
          img.push(commit)
        }
      }
    }
  }
