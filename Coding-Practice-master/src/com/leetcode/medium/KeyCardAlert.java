class KeyCardAlert {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        TreeMap<String, List<Integer>> map = new TreeMap<String, List<Integer>>();
        for(int i = 0; i < keyName.length; i++) {
            String name = keyName[i];
            String time = keyTime[i];
            int colonIndex = time.indexOf(':');
            Integer hour = Integer.parseInt(time.substring(0,colonIndex));
            Integer minute = Integer.parseInt(time.substring(colonIndex+1));
            Boolean updatePrevAlso = false;
            if(minute == 0) {
                updatePrevAlso = true;
            }
            if(map.containsKey(name)) {
                List<Integer> hours = map.get(name);
                hours.set(hour, hours.get(hour) + 1);
                if(updatePrevAlso) {
                    hours.set(hour-1, hours.get(hour-1) + 1);
                }
            } else {
                List<Integer> hours = new ArrayList<Integer>(24);
                for(int j = 0; j < 24; j++) {
                    hours.add(0);
                }
                hours.set(hour, 1);
                if(updatePrevAlso) {
                    hours.set(hour-1, hours.get(hour-1) + 1);
                }
                map.put(name, hours);
            }
        }
        
        List<String> result = new ArrayList<String>();
        Iterator<String> iter = map.keySet().iterator();
        while(iter.hasNext()) {
            String name = iter.next();
            System.out.println(name);
            boolean isAlarmed = isAlarmed(map.get(name));
            if(isAlarmed) {
                result.add(name);
            }
        }
        return result;
    }
    
    public boolean isAlarmed(List<Integer> hours) {
        System.out.println(hours);
        for(int hourFreq : hours) {
            if(hourFreq >= 3) {
                return true;
            }
        }
        return false;
    }
}
