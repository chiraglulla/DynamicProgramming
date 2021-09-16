const allConstruct = (target, wordBank) => {
    const table = 
        Array(target.length + 1)
        .fill()
        .map(() => [])
    table[0] = [[]];

    for(let i = 0; i <= target.length; i++) {
        for(let word of wordBank) {
            if(target.slice(i, i+word.length) === word) {
                const temp = table[i].map(sub => [ ...sub, word ]);
                table[i+word.length].push(...temp);
            }
        }
    }

    return table[target.length];
}

console.log(allConstruct('purple', ['purp', 'p', 'ur', 'le', 'purpl']));
console.log(allConstruct("abcdef", ["ab", "abc", "cd", "def", "abcd", "ef", "c"]));
console.log(allConstruct("skateboard", ["bo", "rd", "ate", "t", "ska", "sk", "boar"]));
console.log(allConstruct("aaaaaaaaaaz", ["a", "aa", "aaa", "aaaa", "aaaaa"]));