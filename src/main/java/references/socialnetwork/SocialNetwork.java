package references.socialnetwork;

import java.util.ArrayList;
import java.util.List;

public class SocialNetwork {

    private List<Member> members = new ArrayList<>();

    public void addMember (String name){
        members.add(new Member(name));
    }

    private Member findByName (String name){
        Member member=null;

        for (Member m : members){
            if (m.getName()==name){
                member=m;
                break;
            }
        }
        return member;
    }

    public void connect (String name, String otherName){
        findByName(name).connectMember(findByName(otherName));
    }

    public List<String> bidirectionalConnections(){

        List<String> connections= new ArrayList<>();

        for (Member m: members){
            for (Member c:m.getConnections()){
                if (c.getConnections().contains(m)){
                    connections.add(m.getName()+" - "+c.getName());
                }
            }
        }
        return connections;
    }

    @Override
    public String toString() {
        return "SocialNetwork{" +
                "members=" + members +
                '}';
    }
}
