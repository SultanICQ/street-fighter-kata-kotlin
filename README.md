## Fight Exercise
​
Requirements:
- A fight between 2 fighters.
- 3 fighter classes: Tank, Asassin y Fighter.
- Stats:
    - STR | DEX | LUCK | VIT | DEF
- 30 points to distribute for each stat (min 1 y max 10).
- Fighter stats:
    - **STR**: Strength (min: 1, max: 5 - each STR point adds 1 y 5 to STR)
    - **DEX**: Evasion (each DEX point adds 5% to evasion)
    - **LUCK**: Critic attack probability (each luck point adds 5% critic attack probability)
    - **VIT**: Health points (each VIT points gives you 100 health point)
    - **DEF**: Defense (each DEF point gives from 1 to 5 defense against attacks)
​
- Critic: Enhance attack in 50%.
- Turns:
    - First dice trow to see which player goes first.
- Dice faced formule: (maxDmg - minDmg) + minDmg
​
### Example:
**Attack:**
##### STR 5 (between 5 y 25) 
- 1 dice of 20 faces + 5
- We trow a 20 
- 20 from dice + 10 from critic (if applicable)
​
##### LUCK 5 (25% critic)
- 1 dice of 100 faces
- We trow 3
- We should apply critic enhancement to the attack.
​
**Defense (Recibe 30 de Dmg):**
##### DEX 5 (25% evasion)
 1 dice of 100 faces
- If we trow 3
- We evade the attack.
​
- If we trow 30 (30 is more than 25%)
- We are not evading the attack and we should calculate the damage taken
​
##### DEF 5 (between 5 y 25)
- 1 dice of 20 faces + 5
- We trow a 10 
- 30 damage - 10 defense = 20 points to extract from our health