#include <bits/stdc++.h>
using namespace std;
#define ll unsigned long long int
#define rep(a,b,c) for(int a=b;a<c;a++)
#define vec vector<int>
#define vecl vector<long long int>
#define vecp vector<pair<int,int>>
#define mpl map<int,int>
#define umap unordered_map<int,int>
#define uset unordered_set<int>
#define sti stack<int>
#define qui queue<int>
#define pb push_back
#define so(a,n) sort(a,a+n)
#define sov(v) sort(v.begin(),v.end())
#define co(a) cout<<a<<" "
#define col(a) cout<<a<<"\n";
#define endl cout<<"\n";
#define fi first
#define se second
#define all(v) v.begin(),v.end()
#define MOD 1000000007
void solve()
{
    ll n;cin>>n;
   ll lcm=1;
   ll gcd=1;
   ll ans=0;
   for(ll i=2;i<=42;i++)
   {
      ll c=(lcm*i)/(__gcd(lcm,i));
      ans=(ans+(i*((n/lcm)-(n/c)))%MOD)%MOD;
      lcm=c;
   }
   col(ans);
}
int main() {
    #ifndef ONLINE_JUDGE
         freopen("input.txt","r",stdin);
         freopen("output.txt","w",stdout);
    #endif
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int t;cin>>t;
    while(t--)
    {
      solve();
    }
    cerr << "Time elapsed :" << clock() * 1000.0 / CLOCKS_PER_SEC << " ms" << '\n';
    return 0;
}