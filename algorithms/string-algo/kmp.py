def get_prefix_array(pattern) :
    p = [0]*len(pattern)
    i = 0
    for j in range(1,len(pattern)) :
        while i > 0 and pattern[i] != pattern[j] : 
            i = p[i-1]
        if pattern[i] == pattern[j] :
            p[j] = i+1
            i+=1

    return p

def kmp(text,pattern):
    prefix_array = get_prefix_array(pattern)
    print(f'Prefix array for {pattern} -> {prefix_array}')
    occurences = []
    j = 0
    for i in range(len(text)) :
        while j > 0 and text[i] != pattern[j] :
            j = prefix_array[j-1]

        if text[i] == pattern[j] :
            j+=1
            if j >= len(pattern) :
                occurences.append(i-j+1)
                j = prefix_array[j-1]
    return occurences


if __name__ == '__main__' :
    text = input('Text to search: ')
    pattern = input('Pattern: ')
    print(f'Pattern occurence Index -> {kmp(text,pattern)}')

                
