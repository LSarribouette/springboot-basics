package fr.lsarribouette.springbootbasics.service;

import fr.lsarribouette.springbootbasics.model.Member;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthServiceMock implements AuthService {

    private List<Member> listMembers;

    public AuthServiceMock() {

        // un conteneur peut etre vide mais pas nul
        listMembers = new ArrayList<>();

        Member tibo = new Member(1, "Thibault", "Marie", "tibo", "mdp", true);
        Member ripiek = new Member(1, "Pierrick", "Anceaux", "ripiek", "mdp", false);
        Member kantun = new Member(1, "Quentin", "Swiderski", "kantun", "mdp", false);

        listMembers.add(tibo);
        listMembers.add(ripiek);
        listMembers.add(kantun);
    }

    @Override
    public List<Member> getAllMembers() {
        return listMembers;
    }

    @Override
    public Member getMemberById(long id) {
        Member found = null;
        for (Member member : listMembers) {
            if(member.getId() == id) {
                found = member;
                break;
            }
        }
        return found;
    }
}
