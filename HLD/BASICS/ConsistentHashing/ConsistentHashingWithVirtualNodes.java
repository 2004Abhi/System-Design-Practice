import java.util.*;
import java.security.*;
import java.nio.charset.StandardCharsets;

class ConsistentHashing{
  //create a new map
  private final SortedMap<Long, String> ring=new TreeMap();
  //define number of virtual nodes
  private final int virtualNodes;

  public ConsistentHashing(int virtualNodes){
    this.virtualNodes=virtualNodes;
  }

  //put node to the ring
  public void putNode(String node){
    for(int i=0;i<virtualNodes;i++){
      ring.put(hash(node+"#"+i),node);
    }
  }

  //remove node from the ring
  public void removeNode(String node){
    for(int i=0;i<virtualNodes;i++){
      ring.remove(hash(node+"#"+i));
    }
  }

  //get the closest node for a key in the ring
  public String getNode(String key){
    if(ring.isEmpty()){
      return null;
    }

    long hash = hash(key);

    SortedMap<Long, String> tailMap= ring.tailMap(hash);

    Long nodeHash = tailMap.isEmpty()
                    ? ring.firstKey()
                    : tailMap.firstKey();
    
    return ring.get(nodeHash);
  }

  //get Hash for a node
  private long hash(String key){
    try{
      //get the 16bytes digest array from md5
      MessageDigest md= MessageDigest.getInstance("MD5");
      byte[] digest=md.digest(key.getBytes(StandardCharsets.UTF_8));

      //construct 32 bit hash ( max 64 bit hash limited by Java Long Size)
      return ((long) (digest[0] & 0xFF) << 24)
          | ((long) (digest[1] & 0xFF) << 16)
          | ((long) (digest[2] & 0xFF) << 8)
          | ((long) (digest[3] & 0xFF));
    }catch(Exception e){
      throw new RuntimeException(e);
    }
  }
}

public class Main {
    public static void main(String[] args) {
        ConsistentHashing ch = new ConsistentHashing(3);
        ch.putNode("Server-A");
        ch.putNode("Server-B");
        ch.putNode("Server-C");

        System.out.println(ch.getNode("user1"));
        System.out.println(ch.getNode("user2"));
        System.out.println(ch.getNode("user3"));
    }
}
