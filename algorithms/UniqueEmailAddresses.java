//https://leetcode.com/problems/unique-email-addresses/

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> emailSet = new HashSet<>();
        for (String email : emails) {
            emailSet.add(filterEmail(email));
        }
        return emailSet.size();
    }

    public String filterEmail(String email) {
        StringBuilder localName = new StringBuilder();
        int len = email.length();
        int i = 0;
        char cursor = email.charAt(i);

        while (cursor != '@' && cursor != '+') {
            if (cursor != '.') {
                localName.append(cursor);
            }
            i++;
            cursor = email.charAt(i);
        }

        while (cursor != '@') {
            cursor = email.charAt(++i);
        }

        return localName + email.substring(i, len - 1);
    }
}
