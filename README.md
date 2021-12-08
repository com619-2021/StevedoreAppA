<div align="center">


![drawing](logo.png)

# StevedoreApp - A

</div>

## **Team**
+ Luke
+ Michal
+ Rahul
+ Julian


## **Commits**
Usage:

- Use crucial and appropriate [Gitmojis](https://gitmoji.carloscuesta.me/)!
- No complete sentences
- If project has issues link them to the merge request
- Fix, Update, Implement are Keys which should be used on every commit


## **Docker**


Pack image
```
 mvn clean install -P packageAsDocker
```

Run image
```
docker run -p 8080:8080 solentdevops/order-example:0.1-SNAPSHOT

```

See container logs
```
docker logs <container id>

docker logs --follow  <container id>
```

Stop container

```
docker stop  <container id>
```

Stop and remove container
```
docker rm -f c3773b47f046
```



