# mac0321

Como criar uma chave SSH para GitHub e configurá-la no repositório remoto
1. Gerar uma chave SSH no seu computador
No terminal (Linux/macOS) ou Git Bash (Windows), rode o comando:
ssh-keygen -t ed25519 -C "seu-email@example.com"
Se o seu sistema não suportar ed25519, use:
ssh-keygen -t rsa -b 4096 -C "seu-email@example.com"
Quando pedir local para salvar, pressione Enter para usar o padrão (~/.ssh/id_ed25519).
Opcionalmente, defina uma senha para proteger a chave ou deixe em branco.
2. Adicionar a chave SSH no agente SSH
Rode o comando para iniciar o agente SSH:
eval "$(ssh-agent -s)"
Depois, adicione sua chave:
ssh-add ~/.ssh/id_ed25519
Substitua o caminho se sua chave tiver nome diferente.
3. Copiar a chave pública para o GitHub
Mostre a chave pública com o comando:
cat ~/.ssh/id_ed25519.pub
Copie todo o conteúdo que aparecer (começa com ssh-ed25519 ou ssh-rsa).
4. Colocar a chave pública no GitHub
1. Entre no GitHub e faça login.
2. Clique na sua foto de perfil > Settings.
3. No menu lateral, clique em "SSH and GPG keys".
4. Clique em "New SSH key".
5. Dê um título para a chave (ex: "Meu PC de casa").
6. Cole a chave pública copiada no campo "Key".
7. Clique em "Add SSH key".
5. Testar a conexão SSH com o GitHub
No terminal, rode:
ssh -T git@github.com
Na primeira vez, digite "yes" para confiar no host.
Se tudo der certo, verá uma mensagem de sucesso.
6. Usar o SSH no seu repositório remoto
Se seu repositório remoto está usando HTTPS, troque para SSH com o comando:
git remote set-url origin git@github.com:usuario/repositorio.git
Substitua "usuario" e "repositorio" pelos seus dados.
Agora os comandos git push e git pull usarão SSH.

---
Se quiser, posso ajudar a fazer isso passo a passo no seu sistema.