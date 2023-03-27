package fr.lsarribouette.springbootbasics.service;

import fr.lsarribouette.springbootbasics.model.Member;
import fr.lsarribouette.springbootbasics.model.Movie;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AuthServiceMock implements AuthService {

    private List<Member> listMembers;

    public AuthServiceMock() {

        // un conteneur peut etre vide mais pas nul
        listMembers = new ArrayList<>();

        Member tibo = new Member(1, "Marie", "Thibault", "tibo", "mdp", true);
        Member ripiek = new Member(1,  "Anceaux", "Pierrick","ripiek", "mdp", false);
        Member kantun = new Member(1,  "Swiderski", "Quentin","kantun", "mdp", false);

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

    @Override
    public Optional<Member> toLogin(String login, String password) {
        Optional<Member> optMember = Optional.empty();
        if(login != null && password != null) {
            for (Member member : listMembers) {
                if(member.getLogin().equals(login) && member.getPassword().equals(password)) {
                    optMember = Optional.of(member);
                    break;
                }
            }
        }
        System.out.println(optMember);
        return optMember;
    }
}
